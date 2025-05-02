class Solution {
    static class TrieNode {
        Map<String, TrieNode> children = new HashMap<>();
        String name = "";
        boolean isDeleted = false;
    }

    Map<String, List<TrieNode>> serializationMap = new HashMap<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode();

        for (List<String> path : paths) {
            TrieNode curr = root;
            for (String folder : path) {
                curr.children.putIfAbsent(folder, new TrieNode());
                curr = curr.children.get(folder);
                curr.name = folder;
            }
        }

        serialize(root);

        for (List<TrieNode> group : serializationMap.values()) {
            if (group.size() > 1) {
                for (TrieNode node : group) {
                    node.isDeleted = true;
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        collectPaths(root, new ArrayList<>(), result);
        return result;
    }

    private String serialize(TrieNode node) {
        if (node.children.isEmpty()) return "";

        List<String> serializedChildren = new ArrayList<>();
        for (String childName : new TreeSet<>(node.children.keySet())) {
            TrieNode child = node.children.get(childName);
            String serialized = serialize(child);
            serializedChildren.add(childName + "(" + serialized + ")");
        }

        String structure = String.join("", serializedChildren);
        serializationMap.computeIfAbsent(structure, k -> new ArrayList<>()).add(node);
        return structure;
    }

    private void collectPaths(TrieNode node, List<String> path, List<List<String>> result) {
        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            TrieNode child = entry.getValue();
            if (child.isDeleted) continue;

            path.add(entry.getKey());
            result.add(new ArrayList<>(path));
            collectPaths(child, path, result);
            path.remove(path.size() - 1);
        }
    }
}
