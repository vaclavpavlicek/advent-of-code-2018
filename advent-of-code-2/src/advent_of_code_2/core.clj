(ns advent-of-code-2.core
  (:gen-class)
  (:require
    [clojure.data :refer :all]))

(defn repetitions-in-line
  [line]
  (distinct (vals (frequencies line))))

(defn add-to-map
  [checksum-map key value]
  (assoc checksum-map key (+ (get checksum-map key) value)))

(defn to-checksum-map
  [checksum-map counts]
  (add-to-map (add-to-map checksum-map :2 (if (some #(= 2 %) counts) 1 0)) :3 (if (some #(= 3 %) counts) 1 0)))

(defn count-checksum
  "Solves first part of task"
  [input]
  (reduce * (vals (reduce to-checksum-map {:2 0 :3 0} (map repetitions-in-line (clojure.string/split input #"\n"))))))

(defn to-ascii
  [str]
  (map int (char-array str)))

(defn to-string
  [char-list]
  (clojure.string/join (map char char-list)))

(defn find-same
  [a b]
  (remove nil? (last (diff a b))))

(defn has-one-or-zero-letters-different
  [ascii letters-in-ascii]
  (some (fn [s-ascii] (and (> (count (find-same ascii s-ascii)) (- (count ascii) 2)) (not (= ascii s-ascii)))) letters-in-ascii))

(defn find-common-letters
  "Solves second part of task"
  [input]
  (let [letters-in-ascii (map to-ascii (clojure.string/split input #"\n"))]
    (let [filtered-ascii (filter #(has-one-or-zero-letters-different %1 letters-in-ascii) letters-in-ascii)]
      (if (empty? filtered-ascii) "" (to-string (find-same (first filtered-ascii) (second filtered-ascii)))))))
