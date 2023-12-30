(defn sum-it
  [s]
  (loop [in s acc 0]
    (if (empty? in)
      acc
      (recur (rest in) (+ acc (first in))))))


(sum-it [])
(sum-it [1])
(sum-it [1 1 1])
(sum-it [4])
(sum-it [4 34])
