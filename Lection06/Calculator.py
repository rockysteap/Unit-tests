class Calculator:

    @staticmethod
    def add(x, y):
        return x + y

    @staticmethod
    def sub(x, y):
        return x - y

    @staticmethod
    def mul(x, y):
        return x * y

    @staticmethod
    def div(x, y):
        if y == 0:
            raise ZeroDivisionError("Деление на ноль")
        return x / y


   # operation = input("Введите операцию (+, -, *, /): ")
    # x = int(input("Введите x: "))
    # y = int(input("Введите y: "))
    #
    # if operation == "+":
    #     print(f"x + y = {add(x, y)}")
    # elif operation == "-":
    #     print(f"x - y = {sub(x, y)}")
    # elif operation == "*":
    #     print(f"x * y = {mul(x, y)}")
    # elif operation == "/":
    #     try:
    #         print(f"x / y = {div(x, y)}")
    #     except ValueError as e:
    #         print('Error: Деление на ноль')
    # else:
    #     print('Некорректная операция')
