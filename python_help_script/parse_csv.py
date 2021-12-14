def parse_on_csv(text: str, column :int):
    new_text = ""
    col = 0
    for i in text:
        if col == column:
            new_text += i + "\n"
            col = 0
        else:
            new_text += i + ","
            col += 1
    print(new_text)

parse_on_csv("000000012341024132031423043214104324111110123401130242142033203143210434222220234011241302302412314203321044333330340121401231413022420313432104444440", 5)
