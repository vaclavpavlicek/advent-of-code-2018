(ns advent-of-code-1.core
  (:gen-class)
  (:require [clojure.string :as str]))

(defn split
  [input]
  (str/split input #"\n"))

(defn parse
  [list]
  (map (fn [n] (Integer/parseInt n)) list))

(defn sum
  [list]
  (reduce + list))

(defn sum-first-and-last
  [splitted]
  (concat (first splitted) (list (+ (last (first splitted)) (first (second splitted)))) (rest (second splitted))))

(defn sum-to-list
  [numbers index]
  (let [splitted (split-at index numbers)]
    (cond
      (empty? (first splitted)) (sum-to-list (second splitted) (+ index 1))
      (empty? (second splitted)) (first splitted)
      :else (sum-to-list (sum-first-and-last splitted) (+ index 1)))))

(defn index-numbers
  [numbers]
  (map-indexed vector (sum-to-list numbers 0)))

(defn find-duplicates
  [numbers-indexed]
  (filter (fn [f-n] (some (fn [n] (and (= (second f-n) (second n)) (< (first f-n) (first n)))) numbers-indexed)) numbers-indexed))

(defn first-twice-number
  [numbers previous-numbers first-number remove-first]
  (let [numbers-with-last (concat (list first-number) numbers)]
    (let [numbers-indexed (if remove-first (rest (index-numbers numbers-with-last)) (index-numbers numbers-with-last))]
      (let [merged (concat previous-numbers numbers-indexed)]
        (let [twice (find-duplicates merged)]
          (if (empty? twice)
            (first-twice-number (rest numbers-with-last) merged (second (last merged)) true)
            (second (first twice))))))))
    0
(defn -main
  [& args]
  (println (first-twice-number (parse (split "INPUT-STRING")) '() 0 false)))