package interview_camp.recursion_backtracking;

import interview_camp.Utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MazeSearch {


    private static boolean canTraverse(int[][] maze) {
        Set<Utils.Pair<Integer>> visited = new HashSet<>();
        if (maze.length == 0) {
            return false;
        }
        return mazeDfs(maze, new Utils.Pair<Integer>(0, 0), visited);


    }

    private static boolean mazeDfs(int[][] maze, Utils.Pair<Integer> position, Set<Utils.Pair<Integer>> visited) {
        if (position.getX() == maze.length - 1 && position.getY() == maze[0].length - 1) {
            return true;
        }


        if (position.getX() < 0 || position.getY() < 0 || position.getX() >= maze.length || position.getY() >= maze[0].length) {
            return false;
        }

        visited.add(position);

        if (maze[position.getX()][position.getY()] == 1) {
            return false;
        }

        List<Utils.Pair<Integer>> successors = List.of(
                new Utils.Pair<>(position.getX() - 1, position.getY()),
                new Utils.Pair<>(position.getX(), position.getY() - 1),
                new Utils.Pair<>(position.getX() + 1, position.getY()),
                new Utils.Pair<>(position.getX(), position.getY() + 1));


        for (Utils.Pair<Integer> next : successors) {
            if (!visited.contains(next)) {
                boolean result = mazeDfs(maze, next, visited);
                if (result) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{
                new int[]{0, 1, 1, 1},
                new int[]{1, 1, 0, 1},
                new int[]{1, 0, 0, 1},
                new int[]{1, 1, 0, 0}
        };

        System.out.println(canTraverse(maze));

    }
}
