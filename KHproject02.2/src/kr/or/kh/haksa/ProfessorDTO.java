package kr.or.kh.haksa;

import java.io.Serializable;

public class ProfessorDTO  extends HaksaDTO implements Serializable, IProfessorDTO {
		private String subject;

		public ProfessorDTO() {
			super();
			}

		public ProfessorDTO(int no, String nai, String irum, String subject) {
			super(no, nai, irum);
			this.subject = subject;
		}
		
		@Override
		public String getSubject() {
			return subject;
		}
		
		@Override
		public void setSubject(String subject) {
			this.subject = subject;
			
		}
				
		@Override
		public String toString() {
			return super.toString() + "ProfessorDTO [subject=" + subject + "]";
		}


}


		
