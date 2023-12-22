(defn penultimate
  [s]
  (cond
    (empty? s) nil
    (empty? (rest s)) nil
    (empty? (rest (rest s))) (first s)
    :else (recur (rest s))))


(= (penultimate []) nil)
(= (penultimate [1]) nil)
(= (penultimate [1 2]) 1)
(= (penultimate [1 2 3]) 2)
(= (penultimate [1 2 3 4]) 3)
