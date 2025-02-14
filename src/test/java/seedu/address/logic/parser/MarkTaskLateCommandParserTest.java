package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_STUDENT;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_TASK;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.MarkTaskLateCommand;

class MarkTaskLateCommandParserTest {

    private MarkTaskLateParserCommand parser = new MarkTaskLateParserCommand();

    @Test
    public void parse_validArgs_markTaskLateCommand() {
        assertParseSuccess(parser, "1 1", new MarkTaskLateCommand(INDEX_FIRST_STUDENT, INDEX_FIRST_TASK));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "2", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                MarkTaskLateCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidAlphabetArgs_throwsParseException() {
        assertParseFailure(parser, "yes no", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                MarkTaskLateCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_missingArgs_throwsParseException() {
        assertParseFailure(parser, "", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                MarkTaskLateCommand.MESSAGE_USAGE));
    }
}
