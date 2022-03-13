/**
 * 
 */
package learn;

import javax.sound.midi.*;

/**
 * @author wenlo
 *
 */
public class MiniMusicPlayer2 implements ControllerEventListener {//��Ҫ����controlerEVent

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		MiniMusicPlayer2 miniMusicPlayer2 = new MiniMusicPlayer2();
		miniMusicPlayer2.go();
	}
	
	public void go() {
	
		try {
			
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			int[] eventsIwant = {127};
			sequencer.addControllerEventListener(this, eventsIwant);
			//��sequenceע���¼�,ע�᷽��ȡ�ü������������������¼���int��
			
			Sequence sequence = new Sequence(Sequence.PPQ, 4);
			Track track =sequence.createTrack();
			
			for(int i=5;i<60;i+=4)
			{
				track.add(makEvent2(144, 1, i, 100, i));
				track.add(makEvent2(176, 1, 127, 0, i));
				//����ʱ����Ϊ127���Զ���controllerEvent(176)�����κ���ֻ�Ǳ���Ӱ��������,����tick ��note on��ͬʱ����
				
				track.add(makEvent2(128, 1, i, 100, i+2));
			}
			
			sequencer.setSequence(sequence);
			sequencer.setTempoInBPM(220);
			sequencer.start();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void controlChange(ShortMessage event) {
		System.out.println("la");
	}

	public static MidiEvent makEvent2(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage aMessage = new ShortMessage();
			aMessage.setMessage(comd, chan, one, two);
			event = new MidiEvent(aMessage, tick);
		} catch (Exception e) {
		}
		return event;
	}

}
