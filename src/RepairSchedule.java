import java.util.ArrayList;

public class RepairSchedule
{
    /** Each element represents a repair by an individual mechanic in a bay. */
    private ArrayList<CarRepair> schedule;

    /** Number of mechanics available in this schedule. */
    private int numberOfMechanics;

    /** Constructs a RepairSchedule object.
     * Precondition: n >= 0
     */
    public RepairSchedule(int n)
    {
        schedule = new ArrayList<CarRepair>();
        numberOfMechanics = n;

    }

    public ArrayList<CarRepair> getSchedule()
    {
        return schedule;
    }

    /** Attempts to schedule a repair by a given mechanic in a given bay as described in part (a).
     * Precondition: 0 <= m < numberOfMechanics and b >= 0
     */
    public boolean addRepair(int m, int b)
    {
        for (CarRepair repair : schedule)
        {
            if (repair.getMechanicNum() == m || repair.getBayNum() == b)
            {
                return false;
            }
        }
        CarRepair newRepair = new CarRepair(m, b);
        schedule.add(newRepair);

        return true; // STUB VALUE
    }

    /** Returns an ArrayList containing the mechanic identifiers of all available mechanics,
     * as described in part (b).
     */
    public ArrayList<Integer> availableMechanics()
    {
        ArrayList<Integer> availableList = new ArrayList<>();
        for (int i = 0; i < numberOfMechanics; i++)
        {
            int count = 0;
            for (CarRepair c : schedule)
            {
                if (c.getMechanicNum() == i)
                {
                    count++;
                }
                if (count == 0)
                {
                    availableList.add(i);
                }
            }
        }
        return availableList;
    }

    /** Removes an element from schedule when a repair is complete. */
    public void carOut(int b)
    {
        for (int i = 0; i < schedule.size(); i++)
        {
            CarRepair carAtIdx = schedule.get(i);
            if (carAtIdx.getBayNum() == b)
            {
                schedule.remove(i);
            }
        }
    }
}