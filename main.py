import sys
import os
import codecs

SEP = ' = '
SEP1 = '\t' + '-' * 50
POSSIBLE_ARGS = ['rep', 'user', 'dirs', 'file', 'path', 'change']
ERROR_COMMAND_NOT_EXIST = "Такой команды нет!"
ERROR_TOO_SMALL_COMMAND = "Слишком мало аргументов!"
ERROR_TOO_BIG_COMMAND = "Слишком много аргументов!"
QUANTITY_ARGS = "Аргументов должно быть 3, пробел - разделитель"



REPOS_PATH = " "
TAB = '  '


def user():
    f = codecs.open(REPOS_PATH)

    raw_list = f.read().split('\n')
    for i in range(len(raw_list)):
        raw_list[i] = raw_list[i][1:] if raw_list[i][0:1] == '\t' else raw_list[i]
    config = {p if len(p.split(SEP)) == 1 else p.split(SEP)[0]: None if len(p.split(SEP)) == 1 else p.split(SEP)[1] for
              p in
              raw_list}

    user_name = "Username = " + (config['name'] if 'name' in config else "no name")
    user_email = "User email = " + (config['email'] if 'email' in config else "no email")
    print(user_name, user_email, sep='\n')
    f.close()


def dirs():
    if not os.path.exists(REPOS_PATH + '\\.git'):
        print("Это не git-репозиторий")
        return
    print(REPOS_PATH)
    print_dirs(REPOS_PATH, 0)


def print_dirs(dir_path, depth):
    for dir_name in os.listdir(dir_path):
        current_path = dir_path + '\\' + dir_name
        print(TAB * depth + ('- ' + dir_name if os.path.isfile(current_path) else dir_name + ":"))
        if os.path.isdir(current_path):
            print_dirs(current_path, depth + 1)


def file(file_name):
    file_path_list = find(REPOS_PATH, file_name)
    if len(file_path_list) == 0:
        print("Такого файла нет!")
        return
    print_file_list(file_path_list)


def print_file_list(file_path_list):
    for file_path in file_path_list:
        if type(file_path) is list:
            print_file_list(file_path)
        else:
            print('\t' + file_path)
            if os.path.isdir(file_path):
                print("Это директория!")
            else:
                print(SEP1)
                contents = None
                with open(file_path) as f:
                    contents = f.read()
                    print(contents)


def find(dir_path, file_name):
    result = list()
    for dir_name in os.listdir(dir_path):
        current_path = dir_path + '\\' + dir_name
        if dir_name.split('.')[0] == file_name or dir_name == file_name:
            result.append(current_path)
        if os.path.isdir(current_path):
            t = find(current_path, file_name)
            if len(t) != 0:
                result.append(t)
    return result


def path(name):
    path_list = find(REPOS_PATH, name)
    print(SEP1)
    print_path(path_list)


def print_path(path_list):
    for current_path in path_list:
        if type(current_path) is list:
            print_path(current_path)
        else:
            print('\t' + current_path)

def change(path):
    return path

def cur_rep():
    print(REPOS_PATH)


if __name__ == '__main__':
    REPOS_PATH = input("Введите путь к папке, содержащей папку .git: ")
    s = input("Введите команду: ")
    com = ["0", "0"]
    while s != 'exit':
        com[0], com[1] = s.split(" ")

        if len(com) != 2:
            print(QUANTITY_ARGS)
            sys.exit()

        current_command = None
        for arg in POSSIBLE_ARGS:
            if arg == com[0]:
                current_command = POSSIBLE_ARGS.index(arg)
                break

        if current_command is None:
            print(ERROR_COMMAND_NOT_EXIST)
            sys.exit()

        # Выполнение команды
        commands = [cur_rep, user, dirs, file, path, change]
        command = commands[current_command]
        print()
        if current_command < 3:
            command()
        else:
            if current_command == 5:
                REPOS_PATH = change(com[1])
            command(com[1])
        print()
        s = input("Введите команду: ")
