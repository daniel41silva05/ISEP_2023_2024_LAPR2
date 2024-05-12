set terminal png

set output 'src/main/java/mdisc/.png'
set title 'Execution time tests'
set xlabel 'Size of Graph (number of edges)'
set ylabel 'Runtime (milliseconds)'
set grid
set xrange [0:*]
set yrange [0:*]
set style fill transparent solid 0.9
plot 'src/main/java/mdisc/plot.csv'  u 1:2 w p t 'Algorithm Performance'
