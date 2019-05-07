package algorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PathsTest
{
    private Graph graph;

    @Before
    public void setUp()
    {
        graph = new AdjacencyBagGraph(6);
        graph.addEdge(0, 5);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(1, 2);
        graph.addEdge(0, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(0, 2);
    }

    @After
    public void tearDown()
    {
        graph = null;
    }

    @Test
    public void testDepthFirstPaths()
    {
        Paths paths = new DepthFirstPaths(graph, 0);
        assertTrue(paths.hasPathTo(3));
        assertTrue(paths.hasPathTo(4));
        assertTrue(paths.hasPathTo(5));
    }

    @Test
    public void testBreadthFirstPaths()
    {
        Paths paths = new BreadthFirstPaths(graph, 0);
        assertTrue(paths.hasPathTo(3));
        assertTrue(paths.hasPathTo(4));
        assertTrue(paths.hasPathTo(5));

        int[] arr = new int[] {0, 2, 4};
        int i = 0;
        for (int v: paths.pathTo(4)) {
            assertEquals(arr[i++], v);
        }
    }
}