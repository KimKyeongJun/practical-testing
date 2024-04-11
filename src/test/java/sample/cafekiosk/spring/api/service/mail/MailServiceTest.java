package sample.cafekiosk.spring.api.service.mail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import sample.cafekiosk.spring.client.mail.MailSendClient;
import sample.cafekiosk.spring.domain.history.mail.MailSendHistoryRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


/**
 * 순수한 Mockito로만 테스트하기
 */
@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class MailServiceTest {

    @Mock // Spy 같은 경우는 실제 객체를 사용한다.
    private MailSendClient mailSendClient;

    @Mock
    private MailSendHistoryRepository mailSendHistoryRepository;

    @InjectMocks
    private MailService mailService;

    @DisplayName("메일 전송 테스트")
    @Test
    void sendMail() {
        // given
        when(mailSendClient.sendMail(anyString(), anyString(), anyString(), anyString())).thenReturn(true);

//        doReturn(true).when(mailSendClient).sendMail(anyString(), anyString(), anyString(), anyString());

        //Mockito.when(mailSendHistoryRepository.save().thenReturn(true);
        BDDMockito.given(mailSendClient.sendMail(anyString(), anyString(), anyString(), anyString())).willReturn(true);

        // when
        boolean result = mailService.sendMail("", "", "", "");

        // then
        assertThat(result).isTrue();
        verify(mailSendHistoryRepository, times(1)).save(any());
    }

}