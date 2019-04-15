package algorithms;

import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class UFTests
{
    @Test
    public void testQuickFindUF()
    {
        try {
            Scanner in = new Scanner(Paths.get("tinyUF.txt"), "UTF-8");

            int N = in.nextInt();
            UF uf = new QuickFindUF(N);

            int p;
            int q;
            while (in.hasNext()) {
                p = in.nextInt();
                q = in.nextInt();
                if (uf.connected(p, q)) continue;
                uf.union(p, q);
            }

            assertEquals(uf.count(), 2);

            in.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}