/**
 * 
 */
package learn;
import javax.sound.midi.*;
/**
 * @author wenlo
 *
 */
public class MiniMusicPlayer1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			Sequence sequence = new Sequence(Sequence.PPQ, 4);
			Track track = sequence.createTrack();
			
			for(int i= 5; i<61;i++)
			{
				track.add(makEvent(144, 1, i, 100, i));
				track.add(makEvent(128, 1, i, 100, i+2));
			}
			
			sequencer.setSequence(sequence);
			sequencer.setTempoInBPM(220);
			sequencer.start();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}



public static MidiEvent makEvent(int comd,int chan,int one,int two,int tick)
{
	MidiEvent event =null;
	try {
		ShortMessage aMessage = new ShortMessage();
		aMessage.setMessage(comd,chan,one,two);
		event = new MidiEvent(aMessage, tick);
	}catch (Exception e) {}
	return event;
}

}