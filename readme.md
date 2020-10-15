# Mars Rover Kata

[Source](https://kata-log.rocks/mars-rover-kata)

## Your Task

You're part of the team that explores Mars by sending remotely controlled vehicles to the surface of the planet.

Develop an API that translates the commands sent from earth to instructions that are understood by the rover.

## Requirements

- You are given the initial starting position (x,y) of a rover and the direction (N,S,E,W) it is facing.

- The rover receives a character array of commands.

- Implement commands that move the rover forward/backward (f,b).

- Implement commands that turn the rover left/right (l,r).

- Implement wrapping at edges. But be careful, planets are spheres:

    - Connect the x edge to the other x edge, so (1,1) for x-1 to (5,1)
    - Connect vertical edges towards themselves in inverted coordinates, so (1,1) for y-1 connects to (5,1).

- Implement obstacle detection before each move to a new square. If a given sequence of commands encounters an obstacle, the rover moves up to the last possible position, aborts the sequence and reports the obstacle.

## TODO

- [R] The method `Rover#execute` should not be public anymore, since the rover expect to receive an array of commands.

- [F] If a given command encounters an obstacle, the rover moves up to the last possible position, aborts the sequence and reports the obstacle.

- [F] A rover can rotate right when it receives the command `r`.

- [R] Is there a better way to express `assertEquals(new Rover(new Position(-1, 0), WEST), rover);` in the test?

    - Is there a chance to extract a DSL to assert that the rover just moved along a direction?
    - Try to use `AssertThat` with custom matchers
    - Try to use `AssertJ`

- [R] Do we still need a class for `Commands` or we can inline that class as a detail of the `Rover`? So that we can build the Rover with a list of commands.

- [E] What happens when we supply a not recognized command? Something different than `f`, `b`, `l`, or `r`.

## Questions

- Could we express the `Commands` class as a `Repository` if we think in terms of Domain-Driven Design?
    - What is the difference between `Commands.from('b')` and `Commands.findByCharacter('b')?
      The only thing I see is that now the term 'b' becomes part of our domain, and not something we have to map
      from the outside to our domain (e.g. 'b' is getting mapped to a `Command` that is part of the domain).

- If we had to re-think at the tests of the `Rover` class, how we might have to rewrite them?
  What does the `Rover` class is really doing? Collaborating with the `Commands`?
