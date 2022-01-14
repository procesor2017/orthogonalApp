package com.orthogonalTool.OrthogonalTool.matrixTest;

import com.orthogonalTool.OrthogonalTool.matrix.ThreeOnX;
import com.orthogonalTool.OrthogonalTool.model.OrthogonalTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThreeOnXTest {
    ThreeOnX threeOnX;
    OrthogonalTable orthogonalTable;

    @BeforeEach
    void setUp(){
        threeOnX = new ThreeOnX();
        orthogonalTable = new OrthogonalTable();
    }


    @Test
    @DisplayName("Two on three")
    void threeOnFour(){
        String myArr[][] = new String[3][4];
        myArr[0][0] = "a";
        myArr[1][0] = "b";
        myArr[2][0] = "c";

        myArr[0][1] = "aa";
        myArr[1][1] = "bb";
        myArr[2][1] = "cc";

        myArr[0][2] = "aaa";
        myArr[1][2] = "bbb";
        myArr[2][2] = "ccc";

        myArr[0][3] = "aaaa";
        myArr[1][3] = "bbbb";
        myArr[2][3] = "cccc";


        orthogonalTable.setWithValueTable(myArr);

        // Response is in row
        String myValueTable[][] = new String[9][4];
        myValueTable[0][0] = "a";
        myValueTable[0][1] = "aa";
        myValueTable[0][2] = "aaa";
        myValueTable[0][3] = "aaaa";

        myValueTable[1][0] = "a";
        myValueTable[1][1] = "bb";
        myValueTable[1][2] = "ccc";
        myValueTable[1][3] = "bbbb";

        myValueTable[2][0] = "a";
        myValueTable[2][1] = "cc";
        myValueTable[2][2] = "bbb";
        myValueTable[2][3] = "cccc";

        myValueTable[3][0] = "b";
        myValueTable[3][1] = "aa";
        myValueTable[3][2] = "ccc";
        myValueTable[3][3] = "cccc";

        myValueTable[4][0] = "b";
        myValueTable[4][1] = "bb";
        myValueTable[4][2] = "bbb";
        myValueTable[4][3] = "aaaa";

        myValueTable[5][0] = "b";
        myValueTable[5][1] = "cc";
        myValueTable[5][2] = "aaa";
        myValueTable[5][3] = "bbbb";

        myValueTable[6][0] = "c";
        myValueTable[6][1] = "aa";
        myValueTable[6][2] = "bbb";
        myValueTable[6][3] = "bbbb";

        myValueTable[7][0] = "c";
        myValueTable[7][1] = "bb";
        myValueTable[7][2] = "aaa";
        myValueTable[7][3] = "cccc";

        myValueTable[8][0] = "c";
        myValueTable[8][1] = "cc";
        myValueTable[8][2] = "ccc";
        myValueTable[8][3] = "aaaa";

        assertTrue(Arrays.deepEquals(myValueTable, threeOnX.ThreeOnFour(orthogonalTable).getWithValueTable()));

    }

}
