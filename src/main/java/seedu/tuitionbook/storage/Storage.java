package seedu.tuitionbook.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.tuitionbook.commons.exceptions.DataLoadingException;
import seedu.tuitionbook.model.ReadOnlyAddressBook;
import seedu.tuitionbook.model.ReadOnlyUserPrefs;
import seedu.tuitionbook.model.UserPrefs;

/**
 * API of the Storage component
 */
public interface Storage extends AddressBookStorage, UserPrefsStorage {

    @Override
    Optional<UserPrefs> readUserPrefs() throws DataLoadingException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    @Override
    Path getAddressBookFilePath();

    @Override
    Optional<ReadOnlyAddressBook> readAddressBook() throws DataLoadingException;

    @Override
    void saveAddressBook(ReadOnlyAddressBook addressBook) throws IOException;

}
