(defn fib
  ([]
   (fib 1 1))
  ([n]
   (take n (fib)))
  ([n m]
   (lazy-seq (cons n (fib m (+ n m))))))


(take 5 (fib))


(defn eager-fib
  [n]
  (loop [remaining n
         res []
         cur 1
         prev 0]
    (cond
      (< remaining 1) res
      :else (recur (dec remaining) (conj res cur) (+ cur prev) cur))))


(eager-fib 0)
(eager-fib 1)
(eager-fib 5)


(= (take 6 (fib)) '(1 1 2 3 5 8))
(= (take 25 (fib)) (eager-fib 25))
