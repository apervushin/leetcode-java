package in.pervush.leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DesignInMemoryFileSystem {

    public static class FileSystem {

        private static class FileSystemObject {
            final Map<String, FileSystemObject> children = new TreeMap<>(); // name -> object
            final StringBuilder content = new StringBuilder();
            final String name;

            private FileSystemObject(final String name) {
                this.name = name;
            }

            public void append(final String content) {
                this.content.append(content);
            }

            public boolean isFile() {
                return !this.content.isEmpty();
            }
        }

        private final FileSystemObject root = new FileSystemObject("");

        public List<String> ls(final String path) {
            final String[] pathParts = path.split("/");
            FileSystemObject current = getObjectByPath(pathParts);
            if (current.isFile()) {
                return List.of(current.name);
            }
            return new ArrayList<>(current.children.keySet());
        }

        public void mkdir(final String path) {
            final String[] pathParts = path.split("/");
            getObjectByPath(pathParts);
        }

        public void addContentToFile(final String filePath, final String content) {
            final String[] pathParts = filePath.split("/");
            final FileSystemObject directory = getObjectByPath(pathParts);
            directory.append(content);
        }

        public String readContentFromFile(final String filePath) {
            final String[] pathParts = filePath.split("/");
            final FileSystemObject directory = getObjectByPath(pathParts);
            return directory.content.toString();
        }

        private FileSystemObject getObjectByPath(final String[] paths) {
            FileSystemObject current = root;
            for (int i = 1; i < paths.length; ++i) {
                current = current.children
                        .compute(paths[i], (k, v) -> v == null ? new FileSystemObject(k) : v);
            }
            return current;
        }
    }

    private static void test1() {
        final FileSystem fs = new FileSystem();
        System.out.println(fs.ls("/"));
        fs.mkdir("/a/b/c");
        fs.addContentToFile("/a/b/c/d", "hello");
        System.out.println(fs.ls("/"));
        System.out.println(fs.readContentFromFile("/a/b/c/d"));
        System.out.println("-----------------------------------------");
    }

    private static void test2() {
        final FileSystem fs = new FileSystem();
        fs.mkdir("/goowmfn");
        System.out.println(fs.ls("/goowmfn"));
        System.out.println(fs.ls("/"));
        fs.mkdir("/z");
        System.out.println(fs.ls("/"));
        System.out.println(fs.ls("/"));
        fs.addContentToFile("/goowmfn/c", "shetopcy");
        System.out.println(fs.ls("/z"));
        System.out.println(fs.ls("/goowmfn/c"));
        System.out.println(fs.ls("/goowmfn"));
        System.out.println("-----------------------------------------");
    }

    public static void main(final String[] args) {
        test1();
        test2();
    }

}
