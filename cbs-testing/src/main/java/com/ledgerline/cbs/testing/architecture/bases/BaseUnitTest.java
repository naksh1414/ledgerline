package com.ledgerline.cbs.testing.architecture.bases;

import com.ledgerline.cbs.core.domain.pagination.PageData;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith (MockitoExtension.class)
public interface BaseUnitTest {

    PageData PAGE_DATA = PageData.of(0, 5, 5, 25);
}
