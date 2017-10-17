package huluwa;

public class Creature {
	private String name;
	private boolean property; // 生物属性(正面或者反面角色)
	private State activity; // 生物正在做的事情(战斗或旁观)
	
	public Creature() {
	}
	
	public Creature(String name,boolean property,State activity){
		setName(name);
		setProperty(property);
		setActivity(activity);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name=name;
	}
	
	public boolean getProperty() {
		return property;
	}
	
	public void setProperty(boolean property) {
		this.property=property;
	}
	
	public State getActivity() {
		return activity;
	}
	
	public void setActivity(State activity) {
		this.activity=activity;
	}

	public String reportName() {
		return getName();
	}
	
	public boolean reportProperty() {
		return getProperty();
	}
	
	public String reportActivity() {
		return getActivity().toString();
	}
}

// 每个角色在战斗中所处状态，分为战斗者、旁观者、指挥者
enum State{
	BATTLER,WATCHER,LEADER;
}