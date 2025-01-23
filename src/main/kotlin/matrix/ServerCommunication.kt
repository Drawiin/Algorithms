package com.drawiin.matrix

/**
 * n -> number of rows
 * m -> number of columns
 * Time complexity: O(n * m)
 * Space complexity: O(n + m)
 */
class ServerCommunication {
    fun countServers(grid: Array<IntArray>): Int {
        val serversPerColumn = mutableMapOf<Int, Int>()
        val serversPerRow = mutableMapOf<Int, Int>()
        var totalConnectedServers = 0

        for (row in grid.indices) {
            for (column in grid[row].indices) {
                if (grid[row][column] == 1) {
                    serversPerColumn[column] = serversPerColumn.getOrDefault(column, 0) + 1
                    serversPerRow[row] = serversPerRow.getOrDefault(row, 0) + 1
                }
            }
        }

        for (row in grid.indices) {
            for (column in grid[row].indices) {
                if (grid[row][column] == 1 && (serversPerColumn[column]!! > 1 || serversPerRow[row]!! > 1)) {
                    totalConnectedServers++
                }
            }
        }

        return totalConnectedServers
    }
}