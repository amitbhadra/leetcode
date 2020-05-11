/*
 * 1232. Check If It Is a Straight Line
 * 
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y]
 * represents the coordinate of a point. Check if these points make a straight
 * line in the XY plane.
 * 
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]] Output: true
 * 
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]] Output: false
 */

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1], x1 = coordinates[1][0], y1 = coordinates[1][1];
        int dx = x1-x0, dy = y1-y0;
        for(int point[]: coordinates) {
            if(dx*(y1-point[1])!=dy*(x1-point[0]))
                return false;
        }
        return true;
    }
}