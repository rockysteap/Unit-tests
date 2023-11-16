class Car:
    def __init__(self, speed=0):
        self.speed = speed
        self.odometer = 0
        self.time = 0

    def print_state(self):
        print(f'I\'m going {self.speed} kph! ')

    def accelerate(self):
        self.speed += 5

    def brake(self):
        if self.speed < 5:
            self.speed = 0
        else:
            self.speed -= 5

    def step(self):
        self.odometer += self.speed
        self.time += 1

    def average_speed(self):
        if self.time != 0:
            return self.odometer / self.time
        else:
            pass


if __name__ == '__main__':

    my_car = Car()
    print('I\'m a car!')
    while True:
        action = input('What should I do? (A)ccelerate, (B)rake, '
                       'show (O)dometer or show average (S)peed? ').upper()
        if action not in 'ABOS' or len(action) != 1:
            print('I don\'t know how to do that.')
            continue
        if action == 'A':
            my_car.accelerate()
        if action == 'B':
            my_car.brake()
        if action == 'O':
            print(f'The car has driven {my_car.odometer} km.')
        if action == 'S':
            print(f'The car\'s average speed was {my_car.average_speed()} kph')
        my_car.step()
        my_car.print_state()
