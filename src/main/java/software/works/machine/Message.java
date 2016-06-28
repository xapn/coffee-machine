package software.works.machine;

import java.util.Objects;

public class Message {

    private String instructions;

    public Message(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Message)) {
            return false;
        } else {
            Message other = (Message) object;
            return Objects.equals(this.instructions, other.instructions);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(instructions);
    }
}