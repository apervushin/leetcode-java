package in.pervush.leetcode.problems;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/guess-the-word/
 */
public class GuessTheWord {

    private static class Master {

        private final String[] words;
        private final String guessedWord;
        private int leftAttempts;

        private Master(final String[] words, final String guessedWord, final int maxAttempts) {
            if (Arrays.stream(words).noneMatch(w -> w.equals(guessedWord))) {
                throw new IllegalArgumentException("pos >= words.size()");
            }
            this.words = words;
            this.guessedWord = guessedWord;
            this.leftAttempts = maxAttempts;
        }

        public int guess(final String word) {
            if (leftAttempts-- <= 0) {
                System.out.println("Either you took too many guesses, or you did not find the secret word.");
                throw new IllegalStateException("Too many attempts");
            }
            if (Arrays.stream(words).noneMatch(w -> w.equals(word))) {
                return -1;
            }

            int result = 0;
            for (int i = 0; i < word.length(); ++i) {
                final char c1 = word.charAt(i);
                final char c2 = guessedWord.charAt(i);
                if (c1 == c2) {
                    ++result;
                }
            }

            if (result == 6) {
                System.out.println("Found: " + word + " (iterations left: " + leftAttempts + ")");
            }

            return result;
        }
    }

    public static void findSecretWord(final String[] words, final Master master) {
        final Set<String> wordsSet = Arrays.stream(words).collect(Collectors.toSet());

        String word = getRandomWord(wordsSet);
        while (!wordsSet.isEmpty()) {
            wordsSet.remove(word);
            int cnt = master.guess(word);
            if (cnt == 6) {
                break;
            }
            final var iterator = wordsSet.iterator();
            while (iterator.hasNext()) {
                final var word2 = iterator.next();
                final int cnt2 = countMatchedChars(word, word2);
                if (cnt2 != cnt) {
                    iterator.remove();
                }
            }
            word = getRandomWord(wordsSet);
        }
    }

    private static String getRandomWord(final Set<String> words) {
        int cnt = new Random().nextInt(words.size());
        for (final String word : words) {
            if (cnt == 0) {
                return word;
            }
            cnt--;
        }
        throw new IllegalStateException();
    }

    private static int countMatchedChars(final String w1, final String w2) {
        int result = 0;
        for (int i = 0; i < w1.length(); ++i) {
            if (w1.charAt(i) == w2.charAt(i)) {
                ++result;
            }
        }
        return result;
    }

    private static void test1() {
        final var words = new String[] {"ccbazz","eiowzz","abcczz", "acckzz"};
        findSecretWord(words, new Master(words, "acckzz", 10));
    }

    private static void test2() {
        final var words = new String[] {"wichbx","oahwep","tpulot","eqznzs","vvmplb","eywinm","dqefpt","kmjmxr","ihkovg","trbzyb","xqulhc","bcsbfw","rwzslk","abpjhw","mpubps","viyzbc","kodlta","ckfzjh","phuepp","rokoro","nxcwmo","awvqlr","uooeon","hhfuzz","sajxgr","oxgaix","fnugyu","lkxwru","mhtrvb","xxonmg","tqxlbr","euxtzg","tjwvad","uslult","rtjosi","hsygda","vyuica","mbnagm","uinqur","pikenp","szgupv","qpxmsw","vunxdn","jahhfn","kmbeok","biywow","yvgwho","hwzodo","loffxk","xavzqd","vwzpfe","uairjw","itufkt","kaklud","jjinfa","kqbttl","zocgux","ucwjig","meesxb","uysfyc","kdfvtw","vizxrv","rpbdjh","wynohw","lhqxvx","kaadty","dxxwut","vjtskm","yrdswc","byzjxm","jeomdc","saevda","himevi","ydltnu","wrrpoc","khuopg","ooxarg","vcvfry","thaawc","bssybb","ccoyyo","ajcwbj","arwfnl","nafmtm","xoaumd","vbejda","kaefne","swcrkh","reeyhj","vmcwaf","chxitv","qkwjna","vklpkp","xfnayl","ktgmfn","xrmzzm","fgtuki","zcffuv","srxuus","pydgmq"};
        findSecretWord(words, new Master(words, "ccoyyo", 10));
    }

    private static void test3() {
        final var words = new String[] {"gaxckt","trlccr","jxwhkz","ycbfps","peayuf","yiejjw","ldzccp","nqsjoa","qrjasy","pcldos","acrtag","buyeia","ubmtpj","drtclz","zqderp","snywek","caoztp","ibpghw","evtkhl","bhpfla","ymqhxk","qkvipb","tvmued","rvbass","axeasm","qolsjg","roswcb","vdjgxx","bugbyv","zipjpc","tamszl","osdifo","dvxlxm","iwmyfb","wmnwhe","hslnop","nkrfwn","puvgve","rqsqpq","jwoswl","tittgf","evqsqe","aishiv","pmwovj","sorbte","hbaczn","coifed","hrctvp","vkytbw","dizcxz","arabol","uywurk","ppywdo","resfls","tmoliy","etriev","oanvlx","wcsnzy","loufkw","onnwcy","novblw","mtxgwe","rgrdbt","ckolob","kxnflb","phonmg","egcdab","cykndr","lkzobv","ifwmwp","jqmbib","mypnvf","lnrgnj","clijwa","kiioqr","syzebr","rqsmhg","sczjmz","hsdjfp","mjcgvm","ajotcx","olgnfv","mjyjxj","wzgbmg","lpcnbj","yjjlwn","blrogv","bdplzs","oxblph","twejel","rupapy","euwrrz","apiqzu","ydcroj","ldvzgq","zailgu","xgqpsr","wxdyho","alrplq","brklfk"};
        findSecretWord(words, new Master(words, "hbaczn", 10));
    }

    public static void main(final String[] args) {
        test1();
        test2();
        test3();
    }
}
