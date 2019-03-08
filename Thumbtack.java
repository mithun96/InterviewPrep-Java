// Thumbtack

/*
Thumbtack is a marketplace that matches users (regular people) to Pros (local professionals) on project basis. For example if a user has a house that needs painting, they will post a house-painting project on Thumbtack and Thumbtack will help them find the best Pro that's available to complete the project.

When a Thumbtack user creates a new project, we recommend the best Pros for the job based on a metric called the Pro Matching Score (PMS). This score is calculated using two factors: the distance the Pro would have to travel to the job, and the Pro's average rating. More specifically, PMS is defined as (max_distance - distance) * rating, where max_distance is the maximal distance that any Pro has from the given user. Naturally, a higher PMS means the Pro is a better match for the project.

You have an array that represents the Pros who are available to complete a new project for a user, where each element of the array is a [distance, rating] tuple. distance is the distance of the Pro from the user's project location, and rating is their overall rating.

Given the array pros for a specific project, determine the k Pros who are best suited to complete it, based on their Pro Matching Score. Return a list of the indices (0-based) at which these Pros appeared in the original pros array, sorted by their PMS score. In the case of a PMS tie, the Pro with the smaller index goes first.

Example

For pros = [[5, 4], [4, 3], [6, 5], [3, 5]] and k = 2, the output should be
bestPros(pros, k) = [3, 1].

The PMSs of the Pros are:

0th pro: (6 - 5) * 4 = 4;
1st pro: (6 - 4) * 3 = 6;
2nd pro: (6 - 6) * 5 = 0;
3rd pro: (6 - 3) * 5 = 15.
The output is [3, 1] since the Pros at indices 1 and 3 have the highest scores. Since pro[3] has a higher PMS than pro[1], index 3 appears first in the array.

Input/Output

[execution time limit] 3 seconds (java)

[input] array.array.integer pros

An array of Pros. For each valid i, pros[i] contains two elements: pros[i][0] is the distance of the ith Pro from the user's location and pros[i][1] is the Pro's overall rating.

Guaranteed constraints:
1 ≤ pros.length ≤ 104,
1 ≤ pros[i].length = 2,
1 ≤ pros[i][j] ≤ 100.

[input] integer k

The number of Pros who should be recommended to complete the user's project.

Guaranteed constraints:
1 ≤ k ≤ pros.length.

[output] array.integer

The indices of the k best Pros to complete the user's project from the original pros array, sorted by their Pro Matching Score. In the case of a PMS tie, the Pro with the smaller index goes first. If there are fewer than k suitable Pros, return all of them.

*/



















/*

Every project on Thumbtack belongs to a category. Each set of two categories has a relevance score from 0 to 1, which represents how relevant they are to each other. A category has a relevance score of 1.0 to itself.

suggestions
Every time a project that belongs to a user is completed, the Thumbtack search bar updates to display the k most relevant category suggestions for that user. These top categories are chosen by first sorting all the categories that are relevant to at least one of the already created projects by relevance. Then, in the case that their relevance is equal, they should be sorted by category name. If the same category is relevant to 2 or more projects, it should be included only once with the maximum relevance score. If there are fewer than k total relevant projects, the suggestions list will be shorter than k.

You have a relevance graph of all the Thumbtack categories, represented as an array of strings of comma-separated words. For each string in categories, the first two elements are the categories being compared and the third is their relevance score. You are also given an array of the categories of the projects that a particular user wants to create.

For example:
"House Painting,Interior Painting,0.8" means that House Painting and Interior Painting have a relevance score of 0.8 (i.e. highly relevant)
and "Handyman,Massage Therapy,0.1" means that Handyman and Massage Therapy have a relevance score of 0.1 (i.e. barely relevant).

Note that if there is no entry for particular pair of categories, it means that their relevance is 0.0 (i.e. they aren't relevant at all and they shouldn't be included in the list of suggestions).

Given the relevance graph categories, the list of the user's projects, and the number of category suggestions the user should see in the Thumbtack search bar k, return an array of arrays that represents the state of the search bar suggestions list after each of the projects in projects is created.

Example

For

categories = [
  "House Painting,Interior Painting,0.9",
  "Handyman,Massage Therapy,0.1",
  "Handyman,House Painting,0.5",
  "House Painting,House Cleaning,0.6",
  "Furniture Assembly,Handyman,0.8",
  "Furniture Assembly,Massage Therapy,0.1",
  "Plumbing Drain Repair,Junk Removal,0.3"
]
projects = ["House Painting", "Handyman"], and k = 3, the output should be
categorySuggestions(categories, projects, k) = [["House Painting", "Interior Painting", "House Cleaning"], ["Handyman", "House Painting", "Interior Painting"]].

After the first project House Painting is completed, the most relevant suggestions are (in order of their relevance):

Category	Relevance
House Painting	1.0
Interior Painting	0.9
House Cleaning	0.6
Handyman	0.5
After the second project is completed, the most relevant suggestions are:
Category	Relevance
Handyman	1.0
House Painting	1.0
Interior Painting	0.9
Furniture Assembly	0.8
House Cleaning	0.6
Massage Therapy	0.1
Input/Output

[execution time limit] 3 seconds (java)

[input] array.string categories

Category relevancies given in the format <category1 name>,<category2 name>,<relevance>. relevance is a float number in the range (0,1] and has no more than 6 decimal places after the point.
It is guaranteed that there are no duplicate entries with the same category pairs (i.e. <category1 name> with <category2 name> will be distinct).

Category names can only consists of spaces and English letters.

Guaranteed constraints:
0 ≤ categories.length ≤ 1000,
5 ≤ categories[i].length ≤ 50.

[input] array.string projects

The categories to which the user's projects belong.

Guaranteed constraints:
0 ≤ projects.length ≤ 1000,
1 ≤ projects[i].length ≤ 30.

[input] integer k

The number of category suggestions that should be shown in the user's search bar.

Guaranteed constraints:
0 ≤ k ≤ 50.

[output] array.array.string

Return the state of the search bar suggestions list after each of the projects in projects is created.

*/























/*
It's important to match the right Thumbtack Pros with the right user projects in order to make sure as many projects as possible can be completed each day. For this task, assume that Thumbtack supports only one project category.

You have a list of projects as an array projectsInfo. Each array element contains the following information about a single project: the project location, the user's max budget in dollars/hour, and the size of the job. Assume that a small job takes 2 hours, a medium job takes 4 hours, and a large job takes 6 hours. You also have an array projectsTimeRanges that lists the time ranges in which the projects can be done.

You also have a list of available Pros as an array prosInfo. Each array element contains information about a Pro's location and their minimum hourly rate in dollars. You also have an array prosTimeRanges that lists the time ranges in which the Pros are available to work.

For this task, the location of the user and the Pro are both represented by two coordinates on a plane.

The time ranges for both the project and the Pro are given in the format hh:mm-hh:mm. It is guaranteed that for each project and each Pro, their time ranges don't overlap and are given in increasing order.

To complete a user's project, the Pro needs to reach the user's location and then complete the project, spending 2, 4, or 6 hours on it according to its size. The distance from the user's location to the Pro's location is equal to the Manhattan distance between two points on the plane. You can assume that the time needed for a Pro to reach the user's location is equal to the distance to this location (in minutes). The Pros should be available to work during the time they are on their way to the user's location and while they are completing the project, but they may be unavailable to work on the way back from the user's location.

Determine the maximum number of projects from the list that the available Pros can complete in a given day, assuming that each Pro can only take on one job per day.

Example

For

projectsInfo = [[0, 0, 5, 0],
                [1, 2, 8, 1],
                [-2, 1, 10, 2]]
projectsTimeRanges = [["08:00-10:30", "11:59-14:00", "20:30-23:05"],
                      ["16:30-21:00"],
                      ["00:00-23:59"]]
prosInfo = [[5, 0, 7],
            [0, 1, 5],
            [-1, -1, 8]]
and

prosTimeRanges = [["10:00-16:06"],
                  ["11:50-14:00", "20:30-23:07"],
                  ["17:00-23:30"]]
the output should be
userProMatching(projectsInfo, projectsTimeRanges, prosInfo, prosTimeRanges) = 2.

The 2nd project can't be completed. The 3rd Pro is the only Pro available for 4 hours during this time period, but she also needs some time to get to this project's location, so it's impossible for her to complete the project.

The remaining two projects can be easily distributed between 3 Pros. For example, the 2nd Pro can complete the 1st project and the 3rd Pro can complete the 3rd project.

The 1st Pro can't complete the 1st project, because his minimum hourly rate is greater than the user's max budget.

Input/Output

[execution time limit] 3 seconds (java)

[input] array.array.integer projectsInfo

For each valid i, projectsInfo[i] contains exactly 4 elements. projectsInfo[i][0] and projectsInfo[i][1] represent the location of the ith project on the plane, projectsInfo[i][2] represents the user's maximum budget for the ith project, and projectsInfo[i][3] represents the size of the project: 0 is a small project (2 hours to complete), 1 is medium (4 hours), and 2 is large (6 hours).

Guaranteed constraints:
1 ≤ projectsInfo.length ≤ 100,
projectsInfo[i].length = 4,
-100 ≤ projectsInfo[i][0] ≤ 100,
-100 ≤ projectsInfo[i][1] ≤ 100,
1 ≤ projectsInfo[i][2] ≤ 100,
0 ≤ projectsInfo[i][3] ≤ 2.

[input] array.array.string projectsTimeRanges

An array with the same length as projectsInfo. For each valid i, projectsTimeRanges[i] represents all time ranges when it is possible to complete the ith project. Each time range is given in the format hh:mm-hh:mm. It is guaranteed that time ranges don't overlap and are given in increasing order, i.e. for each valid j the beginning of the (j + 1)th time range is not earlier than the end of the jth range.

Guaranteed constraints:
projectsTimeRanges.length = projectsInfo.length,
0 ≤ projectsTimeRanges[i].length ≤ 10.

[input] array.array.integer prosInfo

For each valid i, prosInfo[i] contains exactly 3 elements. prosInfo[i][0] and projectsInfo[i][1] represent the location of the ith Pro on the plane, and prosInfo[i][2] represents the minimum rate for the ith Pro.

Guaranteed constraints:
1 ≤ prosInfo.length ≤ 100,
prosInfo[i].length = 3,
-100 ≤ prosInfo[i][0] ≤ 100,
-100 ≤ prosInfo[i][1] ≤ 100,
1 ≤ prosInfo[i][2] ≤ 100.

[input] array.array.string prosTimeRanges

An array of the same length as prosInfo, representing the time ranges for all Pros in the same format as projectsTimeInfo.

Guaranteed constraints:
prosTimeRanges.length = prosInfo.length,
0 ≤ prosTimeRanges[i].length ≤ 10.

[output] integer

The maximum number of projects from the list that the available Pros can complete in a given day, assuming that each Pro can only take on one job per day.


*/


