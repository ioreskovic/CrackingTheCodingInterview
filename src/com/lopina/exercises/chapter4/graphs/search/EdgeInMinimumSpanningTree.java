package com.lopina.exercises.chapter4.graphs.search;

/**
 * We will solve this using MST cycle property, which says that, "For any cycle C in the graph, if the weight of an edge e of C is larger than the weights of all other edges of C, then this edge cannot belong to an MST."</br>
 * Now, run the following O(E+V) algorithm to test if the edge E connecting vertices u and v will be a part of some MST or not.</br>
 * Step 1</br>
 * Run dfs from one of the end-points(either u or v) of the edge E considering only those edges that have weight less than that of E.</br>
 * Step 2</br>
 * Case 1 If at the end of this dfs, the vertices u and v get connected, then edge E cannot be a part of some MST. This is because in this case there definitely exists a cycle in the graph with the edge E having the maximum weight and it cannot be a part of the MST(from the cycle property).</br>
 * Case 2 But if at the end of the dfs u and v stay disconnected, then edge E must be the part of some MST as in this case E is not always the maximum weight edge of all the cycles that it is a part of</br>
 * 
 * @author eivaore
 *
 */
public class EdgeInMinimumSpanningTree {

}
