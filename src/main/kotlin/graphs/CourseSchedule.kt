package com.drawiin.graphs

/**
 * Problem Description:
 * You’re given a list of course prerequisites represented as pairs of courses (e.g., [1, 0] means to take course 1 you need to first take course 0). The task is to determine if it’s possible to finish all the courses given the prerequisites.
 *
 * Code Implementation
 * Solution Class
 * The solution involves detecting cycles in a graph, as a cycle means it’s impossible to complete all courses.
 */
class CourseSchedule {
    fun canFinish(numCourses: Int, prerequisites: List<Pair<Int, Int>>): Boolean {
        // used to store the dependencies of each course { course: [dependencies] }
        val dependencyMap = mutableMapOf<Int, MutableList<Int>>()
        // used to store the courses that are being validated to detect cycles we can also think of if as the path of the DFS
        val coursesInValidation = mutableSetOf<Int>()

        // First we start the dependency map with all courses and empty dependencies
        for (course in 0 until numCourses) {
            dependencyMap[course] = mutableListOf()
        }
        prerequisites.forEach { (course, dependency) ->
            dependencyMap[course]!!.add(dependency)
        }

        println("dependency map = $dependencyMap")

        fun canFinishCourse(course: Int): Boolean {
            // if the course is already in validation, it means that there is a cycle
            if (course in coursesInValidation) return false

            // if the course dependencies are empty, it means that the course doesn't have any dependencies and then can be finished
            // or the course was already validated and can be finished
            if (dependencyMap[course]!!.isEmpty()) return true

            // add the course to the validation set before proceed so we can detect cycles
            coursesInValidation.add(course)

            // check if the course dependencies can be finished
            dependencyMap[course]!!.forEach { dependency ->
                // if the dependency can't be finished, the course can't be finished so we return false right away
                if (!canFinishCourse(dependency)) return false
            }

            // remove the course from the validation set after the validation
            coursesInValidation.remove(course)
            // set the course dependencies to empty so we don't need to validate it again
            dependencyMap[course] = mutableListOf()

            // then we just return true because we perform all the validations and the course can be finished
            return true
        }

        // Now we need to run the check for each course to check if all of them can be finished
        // because there is no guarantee that the courses are connected
        for (course in 0 until numCourses) {
            // if any course can't be finished, we return false right away
            if (!canFinishCourse(course)) return false
        }
        // if all courses can be finished, we return true
        return true
    }
}