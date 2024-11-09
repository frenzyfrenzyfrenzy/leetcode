package com.svintsov.dijkstra;

import static java.util.Comparator.comparing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra {

/*    public List<String> findShortestPath(Map<String, Set<String>> graph, String source, String destination) {
        new PriorityQueue<RoutePoint>(comparing(RoutePoint::getDistanceFromSource));
    }*/


    @Setter
    @Getter
    @AllArgsConstructor
    private static class RoutePoint {
        private final String nodeName;
        private int distanceFromSource;
    }

}
