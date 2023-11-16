import doctest

def check_password(password):
    """

    :param password:
    :return:

    >>> password = 'password'
    >>> len(password) >= 8
    True
    """
    if len(password) < 8:
        raise AssertionError('Длина пароля должна быть не меньше 8 символов')
    assert True, 'Пароль удовлетворяет требованиям.'


check_password('hi!hello')
doctest.testmod()

