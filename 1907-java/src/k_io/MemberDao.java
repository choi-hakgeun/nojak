package k_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	String fileName = "member.dat";
	
	public List<MemberVo> search(MemberSearch ms){
		List<MemberVo> list = new ArrayList<MemberVo>();
		//member.dat에 있는 자료들을 읽어 list에 추가한 후 반환
		try {
			InputStream is = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(is);
			String find = ms.getFindStr().getText();
			
			List<MemberVo> temp = (List)ois.readObject();
			for(MemberVo vo : temp) {
				if(vo.equals(find)) {
					list.add(vo);
				}
			}
		}catch(Exception ex) {
			list = null;
		}
		
		return list;
	}
	
	public boolean insert(MemberVo vo) {
		boolean b = true;
		
		//파일의 정보를 읽어서 메모리에 적재
		//매개변수로 입력된 vo를 메모리에 추가
		//해당 내용을 다시 파일에 저장
		try {//2번
			InputStream is = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(is);
			List<MemberVo> list = (List)ois.readObject();
			list.add(vo);
			ois.close();
			is.close();
			
			OutputStream os = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(list);
			oos.flush();
			oos.close();
			os.close();
			
		}catch(Exception ex) {
			b = false;
		}finally {
			return b;
		}
	}
	
	public MemberVo search(String findMid) {
		MemberVo vo = null;
		List<MemberVo> list;
		try {
			InputStream is = new FileInputStream(fileName);//다형화
			ObjectInputStream ois = new ObjectInputStream(is);
			list = (List)ois.readObject();
			for(MemberVo v : list) {
				if(v.getmId().equals(findMid)) {
					vo = v;
					ois.close();
					is.close();
					break;
				}
			}
			
		}catch(Exception ex) {
			vo = null;
		}finally {
			return vo;
		}
		
	}
	public boolean modify(MemberVo vo) {
		boolean b = true;
		try {
			int index = -1;
			InputStream is = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(is);
			List<MemberVo>list = (List)ois.readObject();
			for(int i=0; i<list.size(); i++) {
				MemberVo v = list.get(i);
				if(v.getmId().equals(vo.getmId())) {
					list.set(i,  vo);
					index = i;
					break;
				}
					
				
			}
			ois.close();
			is.close();
			if(index == -1 ) {
				b = false;
			}else {
				OutputStream os = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(list);
				oos.flush();
				oos.close();
				os.close();
			}
			
		}catch(Exception ex) {
			b = false;
			ex.printStackTrace();
		}finally {
			return b;
		}
	}
	public boolean delete(String mId) {
		boolean b = true;
		int index = -1;
		try {
			InputStream is = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(is);
			List<MemberVo> list = (List)ois.readObject();
			for(int i=0; i<list.size(); i++) {
				MemberVo v = list.get(i);
				if(v.getmId().equals(mId)) {
					index = i;
					list.remove(index);
					break;
				}
			}
			ois.close();
			is.close();
			
			if(index >= 0) {
				OutputStream os = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(list);
				oos.flush();
				oos.close();
				os.close();				
			}else {
				b = false;
			}
			
		}catch(Exception ex) {
			b = false;
			ex.printStackTrace();
		}finally {
			return b;
		}
	}

}
