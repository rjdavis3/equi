# TDD Solutions Java

Various TDD implementations of simple problems.

| Service   | Develop | Master |
|-----------|---------|--------|
| CI Status | [![Build Status](https://travis-ci.org/rjdavis3/tdd-solutions-java.svg?branch=develop)](https://travis-ci.org/rjdavis3/tdd-solutions-java) | [![Build Status](https://travis-ci.org/rjdavis3/tdd-solutions-java.svg?branch=master)](https://travis-ci.org/rjdavis3/tdd-solutions-java) |

## Projects

### Equi
Find an index in an array such that its prefix sum equals its suffix sum.

https://app.codility.com/public-report-detail/

### Missing Integer
Find the smallest positive integer that does not occur in a given sequence.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [-1, -3], the function should return 1.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [-1,000,000..1,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).

https://app.codility.com/demo/results/demo4JQ3G6-97A/

## Building from source

	1. Install Maven
	2. Install JDK 8
	3. Clone the repository.
	3. Navigate to repository directory and run `mvn install`

