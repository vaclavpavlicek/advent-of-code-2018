(ns advent-of-code-1.core-test
  (:require [clojure.test :refer :all]
            [advent-of-code-1.core :refer :all]))

(deftest split-test
  (testing "Splits input text to list."
    (is (= '("+1" "+1" "+1") (split "+1\n+1\n+1")))))

(deftest parse-test
  (testing "Parses string list to integer list."
    (is (= '(1 1 1) (parse '("+1" "+1" "+1"))))))

(deftest sum-test
  (testing "Sums list of integer."
    (is (= 3 (sum '(1 1 1))))))

(deftest sum-to-list-test
  (testing "Sums numbers one by one to list."
    (is (= '(0 1 2 3) (sum-to-list '(0 1 1 1) 0)))))

;(deftest first-twice-number-test
 ; (testing "Finds first sum which is first twice in list."
  ;  (is (= 0 (first-twice-number '(1 -2 1) '() 0)))))

;(deftest first-twice-number-repeat-test
 ; (testing "Finds first sum which is first twice in list and sum is repeated."
  ;  (is (= 10 (first-twice-number '(3 3 4 -2 -4) '() 0)))))

(deftest first-twice-number-repeat-2-test
  (testing "Finds first sum which is first twice in list and sum is repeated."
    (is (= 5 (first-twice-number '(-6 3 8 5 -6) '() 0 false)))))