# Mars Rover Kata

[Source](https://kata-log.rocks/mars-rover-kata)

## Your Task

You're part of the team that explores Mars by sending remotely controlled vehicles to the surface of the planet.

Develop an API that translates the commands sent from earth to instructions that are understood by the rover.

## Requirements

- You are given the initial starting point (x,y) of a rover and the direction (N,S,E,W) it is facing.

- The rover receives a character array of commands.

- Implement commands that move the rover forward/backward (f,b).

- Implement commands that turn the rover left/right (l,r).

- Implement wrapping at edges. But be careful, planets are spheres:

    - Connect the x edge to the other x edge, so (1,1) for x-1 to (5,1)
    - Connect vertical edges towards themselves in inverted coordinates, so (1,1) for y-1 connects to (5,1).

- Implement obstacle detection before each move to a new square. If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point, aborts the sequence and reports the obstacle.

## TODO

- [R] `Point` seems to be too generic. Is there a better name we can use? `Position`, or `Location`?

- [F] A rover start with the direction it is facing (N,S,E,W).

- [F] A rover can be moved forward when it receives the command `f`.

- [F] A rover can be moved backward when it receives the command `b`.

- [F] A rover can rotate left with it received the command `l`.

- [F] A rover can rotate left with it received the command `r`.
