char* capitalizeTitle(char* s) {
    for (int i = 0, j = 0; i <= strlen(s); ++i) {
        if (i == strlen(s) || s[i] == ' ') {
            if (i - j > 2)
                s[j] = toupper(s[j]);
            j = i + 1;
        }
        else
            s[i] = tolower(s[i]);
    }
    return s;
}