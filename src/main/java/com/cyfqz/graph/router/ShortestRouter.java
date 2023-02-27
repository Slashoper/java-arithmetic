package com.cyfqz.graph.router;

import java.util.List;

public class ShortestRouter {

    public static void main(String[] args) {

    }

}

class Graph {
    private static final int maxVerterx = 20;
    int[][] adjMaterix;

    int nVerterx;
    Vertex[] verterxs;

    public Graph() {
        adjMaterix = new int[maxVerterx][maxVerterx];
        verterxs = new Vertex[maxVerterx];
        nVerterx = 0;
    }

    public void addVertex(String label) {
        this.verterxs[++nVerterx] = new Vertex(label, false);
    }

    public void addEdg(int start, int end) {
        this.adjMaterix[start][end] = 1;
        this.adjMaterix[end][start] = 1;
    }

    public boolean isEnd() {
        for (int i = 0; i < nVerterx; i++) {
            if (!verterxs[i].isVisited()) {
                return false;
            }
        }
        return true;
    }
}

class Vertex {
    private String label;
    private boolean visited;

    public Vertex(String lable, boolean visited) {
        this.label = lable;
        this.visited = visited;
    }

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
