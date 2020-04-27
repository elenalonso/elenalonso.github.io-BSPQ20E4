package serialization;

import server.easyFilminData.Actor;

public class ActorData {

protected String name;
public ActorData() {

}
public ActorData(Actor a) {
    this.name = a.getName();
} 

public String getName() {
    return this.name;
}

public void setName(String name) {
    this.name = name;
}
}
