(defn counter
  ([s]
   (counter s 0))
  ([s c]
   (println (str s \, c))
   (cond
     (empty? s) c
     :else (recur (rest s) (+ c 1)))))


((defn tests
   []
   (and
     (= (counter []) 0)
     (= (counter [1]) 1))))
