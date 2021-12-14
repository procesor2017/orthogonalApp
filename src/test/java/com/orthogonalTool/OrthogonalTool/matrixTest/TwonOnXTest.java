package com.orthogonalTool.OrthogonalTool.matrixTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import com.orthogonalTool.OrthogonalTool.matrix.TwoOnX;
import com.orthogonalTool.OrthogonalTool.model.OrthogonalTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TwonOnXTest {
    TwoOnX twoOnX;
    OrthogonalTable orthogonalTable;
    
    @BeforeEach
    void setUp(){
        twoOnX = new TwoOnX();
        orthogonalTable = new OrthogonalTable();
    }


    @Test
    @DisplayName("Two on three")
    void twoOnThree(){
        String myArr[][] = new String[2][3];
        myArr[0][0] = "Oracle";
        myArr[1][0] = "MySqlite";

        myArr[0][1] = "Hybernate";
        myArr[1][1] = "JPA";

        myArr[0][2] = "Rest";
        myArr[1][2] = "rwi";

        int poorTable[][] = new int[4][3];
        poorTable[0][0] = 0;
        poorTable[0][1] = 0;
        poorTable[0][2] = 0;

        poorTable[1][0] = 0;
        poorTable[1][1] = 1;
        poorTable[1][2] = 1;

        poorTable[2][0] = 1;
        poorTable[2][1] = 0;
        poorTable[2][2] = 1;

        poorTable[3][0] = 1;
        poorTable[3][1] = 1;
        poorTable[3][2] = 0;

        String myValueTabel[][] = new String[4][3];
        myValueTabel[0][0] = "Oracle";
        myValueTabel[0][1] = "Hybernate";
        myValueTabel[0][2] = "Rest";

        myValueTabel[1][0] = "Oracle";
        myValueTabel[1][1] = "JPA";
        myValueTabel[1][2] = "rwi";

        myValueTabel[2][0] = "MySqlite";
        myValueTabel[2][1] = "Hybernate";
        myValueTabel[2][2] = "rwi";

        myValueTabel[3][0] = "MySqlite";
        myValueTabel[3][1] = "JPA";
        myValueTabel[3][2] = "Rest";


        orthogonalTable.setWithValueTable(myArr);
        orthogonalTable.setPoorTable(poorTable);

        assertTrue(Arrays.deepEquals(poorTable, twoOnX.twoOnThree(orthogonalTable).getPoorTable()));
        assertTrue(Arrays.deepEquals(myValueTabel, twoOnX.twoOnThree(orthogonalTable).getWithValueTable()));
    }

}
