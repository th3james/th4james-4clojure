(defn reverser
  [s]
  (loop [in s res '()]
    (if (empty? in)
      res
      (recur (rest in) (conj res (first in))))))


(and
  (= (reverser []) [])
  (= (reverser [1]) [1])
  (= (reverser [1 2]) [2 1]))
