package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class SentenceReducer {
    private static final Set<String> STOP_WORDS = Set.of(
            "a", "an", "the", "and", "or", "but", "is", "are", "was", "were",
            "in", "on", "at", "to", "of", "for", "with", "as", "by", "that",
            "this", "it", "from", "i", "you", "he", "she", "they", "we", "my",
            "your", "his", "her", "their", "like"
    );

    public static List<String> reduce(String text) {
        if (text == null || text.trim().isEmpty()) {
            return new ArrayList<>();
        }

        String[] sentences = text.split("(?<=[.!?])\\s*");
        int n = sentences.length;

        List<Set<String>> wordSets = new ArrayList<>();
        for (String s : sentences) {
            Set<String> words = Arrays.stream(s.toLowerCase().split("\\W+"))
                    .filter(w -> !w.isEmpty())
                    .filter(w -> !STOP_WORDS.contains(w))
                    .collect(Collectors.toSet());
             wordSets.add(words);
        }

        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
            for (int j = 0; j < n; j++) {
                if (i != j && !Collections.disjoint(wordSets.get(i), wordSets.get(j))) {
                    graph.get(i).add(j);
                }
            }
        }

        boolean[] visited = new boolean[n];
        List<Integer> maxComponent = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, graph, visited, component);
                if (component.size() > maxComponent.size()) {
                    maxComponent = component;
                }
            }
        }

        List<String> result = new ArrayList<>();
        for (int index : maxComponent) {
            result.add(sentences[index]);
        }
        return result;
    }

    private static void dfs(int v, List<Set<Integer>> graph, boolean[] visited, List<Integer> component) {
        visited[v] = true;
        component.add(v);
        for (int u : graph.get(v)) {
            if (!visited[u]) {
                dfs(u, graph, visited, component);
            }
        }
    }
}
