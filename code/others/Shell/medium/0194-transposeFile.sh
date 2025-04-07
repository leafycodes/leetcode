# Read from the file file.txt and print its transposed content to stdout.

awk '
{
    for (i = 1; i <= NF; i++) {
        a[i, NR] = $i
        if (NR > max_row) max_row = NR
    }
    max_col = NF
}
END {
    for (i = 1; i <= max_col; i++) {
        for (j = 1; j <= max_row; j++) {
            printf a[i, j] (j == max_row ? "\n" : " ")
        }
    }
}' file.txt