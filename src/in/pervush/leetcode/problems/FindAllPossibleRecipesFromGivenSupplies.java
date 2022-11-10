package in.pervush.leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
 */
public class FindAllPossibleRecipesFromGivenSupplies {

    private enum RecipeStatus {
        NOT_PROCESSED,
        PROCESSING,
        PROCESSED_AND_FOUND,
        PROCESSED_AND_NOT_FOUND
    }

    private static class Recipe {
        public RecipeStatus status;
        public final int pos;

        private Recipe(final int pos, final RecipeStatus status) {
            this.pos = pos;
            this.status = status;
        }
    }

    public static List<String> findAllRecipes(final String[] recipes, final List<List<String>> ingredients,
                                              final String[] supplies) {
        final Set<String> suppliesSet = Arrays.stream(supplies).collect(Collectors.toUnmodifiableSet());
        final Map<String, Recipe> result = new HashMap<>();
        for (int i = 0; i < recipes.length; ++i) {
            result.put(recipes[i], new Recipe(i, RecipeStatus.NOT_PROCESSED));
        }

        for (final String recipe : recipes) {
            findAllRecipes(ingredients, suppliesSet, result, recipe);
        }
        return result.entrySet().stream().filter(v -> v.getValue().status == RecipeStatus.PROCESSED_AND_FOUND)
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }

    private static void findAllRecipes(final List<List<String>> ingredients, final Set<String> supplies,
                                       final Map<String, Recipe> state, final String recipeKey) {
        final var recipe = state.get(recipeKey);
        if (recipe.status != RecipeStatus.NOT_PROCESSED) {
            return;
        }
        recipe.status = RecipeStatus.PROCESSING;

        boolean canConstruct = true;
        for (final var ingredient : ingredients.get(recipe.pos)) {
            final var ingredientRecipe = state.get(ingredient);
            if (ingredientRecipe != null) {
                findAllRecipes(ingredients, supplies, state, ingredient);
                if (ingredientRecipe.status == RecipeStatus.PROCESSED_AND_NOT_FOUND
                        || ingredientRecipe.status == RecipeStatus.PROCESSING) {
                    canConstruct = false;
                    break;
                }
            } else if (!supplies.contains(ingredient)) {
                canConstruct = false;
                break;
            }
        }

        recipe.status = canConstruct ? RecipeStatus.PROCESSED_AND_FOUND : RecipeStatus.PROCESSED_AND_NOT_FOUND;
    }

    public static void test1() {
        System.out.println(findAllRecipes(
                new String[] {"bread"},
                List.of(
                        List.of("yeast","flour")
                ),
                new String[] {"yeast","flour","corn"}
        ));
    }

    public static void test2() {
        System.out.println(findAllRecipes(
                new String[] {"bread","sandwich"},
                List.of(
                        List.of("yeast","flour"),
                        List.of("bread","meat")
                ),
                new String[] {"yeast","flour","meat"}
        ));
    }

    public static void test3() {
        System.out.println(findAllRecipes(
                new String[] {"bread","sandwich","burger"},
                List.of(
                        List.of("yeast","flour"),
                        List.of("bread","meat"),
                        List.of("sandwich","meat","bread")
                ),
                new String[] {"yeast","flour","meat"}
        ));
    }

    public static void test4() {
        System.out.println(findAllRecipes(
                new String[] {"ju","fzjnm","x","e","zpmcz","h","q"},
                List.of(
                        List.of("d"),
                        List.of("hveml","f","cpivl"),
                        List.of("cpivl","zpmcz","h","e","fzjnm","ju"),
                        List.of("cpivl","hveml","zpmcz","ju","h"),
                        List.of("h","fzjnm","e","q","x"),
                        List.of("d","hveml","cpivl","q","zpmcz","ju","e","x"),
                        List.of("f","hveml","cpivl")
                ),
                new String[] {"f","hveml","cpivl","d"}
        ));
    }

    public static void main(final String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
}
