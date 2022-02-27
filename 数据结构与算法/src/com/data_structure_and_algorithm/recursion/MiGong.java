package com.data_structure_and_algorithm.recursion;

/**
 * 递归解决迷宫问题
 */

public class MiGong {
    public static void main(String[] args) {
        //创建一个二维数组，模拟迷宫
        int[][] map = new int[8][7];
        //使用1表示墙，先把上下置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        //输出地图
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }

        //使用递归回溯
        setWay(map,1,1);

        //输出新的地图，即标识过的地图
        System.out.println("走过后的地图");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //使用递归回溯来找路
    //如果能找到map[6][5]位置，说明通路找到
    //1表示墙，2表示可以走，3表示该点已经走过，但走不通
    //定一个策略，下 右 上 左，如果该点走不通，在回溯
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {//说明已走通
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {//说明是死路
                    map[i][j] = 3;
                    return false;
                }
            }else {//说明map[i][j]！=0，可能为1，2，3
                return false;
            }
        }
    }
}
