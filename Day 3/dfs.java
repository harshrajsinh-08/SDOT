import java.util.*;

public class dfs {
    private Map<Integer, List<Integer>> adjList;

    public dfs() {
        adjList = new HashMap<>();
    }

    public void addEdge(int src, int dest) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    public void dfs(int startNode, Set<Integer> visited) {
        visited.add(startNode);
        System.out.print(startNode + " ");

        for (int neighbor : adjList.getOrDefault(startNode, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        dfs graph = new dfs();

        System.out.print("Enter the number of nodes: ");
        int nodes = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter the edges (format: src dest):");
        for (int i = 0; i < edges; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            graph.addEdge(src, dest);
        }

        System.out.print("Enter the starting node for DFS: ");
        int startNode = scanner.nextInt();

        System.out.println("DFS Traversal:");
        Set<Integer> visited = new HashSet<>();
        graph.dfs(startNode, visited);

        scanner.close();
    }
}
