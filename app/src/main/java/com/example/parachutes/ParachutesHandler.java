package com.example.parachutes;

//handling the parachutes dropped by the plane - whenever a parachute object finish its task,
//it deletes it - the avoid an aggregation of inactive objects, or even a possible overflow
public interface ParachutesHandler {
   void add(Parachute parachute);
}
