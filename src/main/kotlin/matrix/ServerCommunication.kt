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

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    serversPerColumn[j] = serversPerColumn.getOrDefault(j, 0) + 1
                    serversPerRow[i] = serversPerRow.getOrDefault(i, 0) + 1
                }
            }
        }

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1 && (serversPerColumn[j]!! > 1 || serversPerRow[i]!! > 1)) {
                    totalConnectedServers++
                }
            }
        }

        return totalConnectedServers
    }
}