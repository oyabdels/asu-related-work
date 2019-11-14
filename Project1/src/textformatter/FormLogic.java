package textformatter;
import java.util.ArrayList;
import java.util.List;

public class FormLogic
{

	List<String> errors = new ArrayList<>();
	List<String> formatted_input = new ArrayList<>();

	List<String> formatLength(List<String> input, int char_length)
	{

		for (int i = 0; i < input.size(); i++) // loop each line
		{
			if (input.get(i).length() > char_length) // if exceeds char limit
			{
				errors.add("Character limit on line " + (i + 1) + " exceeded - splitting lines."); // report error
				char_length--;
				int loop = 0;
				for (int k = (input.get(i).length() / char_length); k > 0; k--) // if line exceeds amount by twice or more the limit, it needs to be split again.
				{
					String temp = input.get(i).substring((loop * char_length), ((loop * char_length) + char_length));
					if (k != 0) temp = temp + "-";
					formatted_input.add(temp);
					if (i == input.size() - 1 && k == 1)
					{
						formatted_input.add(input.get(i).substring((loop * char_length) + char_length, input.get(i).length()));
					}
					loop++;
				}
			} else formatted_input.add(input.get(i));
		}
		return formatted_input;
	}
}
