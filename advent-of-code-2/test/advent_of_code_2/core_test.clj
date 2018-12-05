(ns advent-of-code-2.core-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2.core :refer :all]))

(deftest repetition-test
  (testing "Creates list of repetions count in string."
    (is (= '(2 1) (repetitions-in-line "abcda")))))

(deftest count-checksum-test
  (testing "Counts checksum of input string."
    (is (= 12 (count-checksum "abcdef\nbababc\nabbcde\nabcccd\naabcdd\nabcdee\nababab")))))

(deftest to-ascii-test
  (testing "Converts string to listo of ASCII codes."
    (is (= '(97 98 99 100 101) (to-ascii "abcde")))))

(deftest find-same-test
  (testing "Return list with elements, which contains both lists."
    (is (= '(102 103 104 106) (find-same '(102 103 104 117 106) '(102 103 104 105 106))))))

(deftest to-ascii-test
  (testing "Converts string to listo of ASCII codes."
    (is (= "abcde" (to-string '(97 98 99 100 101))))))

(deftest find-common-letters-test
  (testing "a"
    (is (= "fgij" (find-common-letters "abcde\nfghij\nklmno\npqrst\nfguij\naxcye\nwvxyz")))))