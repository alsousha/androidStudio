public class MainActivity extends AppCompatActivity {

    TextView timerDown;
    TextView timerUp;
    Button resetTimerUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerDown = findViewById(R.id.timerDown);
        timerUp = findViewById(R.id.timerUp);
        resetTimerUp = findViewById(R.id.resetTimerUp);

        int startTime = 10000;
        //set timer down
        new CountDownTimer(startTime, 1000) {
            @Override
            public void onTick(long l) {
                NumberFormat f = new DecimalFormat("00");
                long hour = (l / 3600000) % 24;
                long min = (l / 60000) % 60;
                long sec = (l / 1000) % 60;
                timerDown.setText(
                            f.format(hour) + ":" +
                            f.format(min) + ":" +
                            f.format(sec));
            }

            @Override
            public void onFinish() {
                timerDown.setText("00:00:00");

            }
        }.start();
        startTimerUp();
        resetTimerUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ?? how to stop an already running function? 
                try {
                    startTimerUp();
                }catch (Exception e){

                }
            }
        });
    }

    private void startTimerUp(){
        //set timer up
        int startTime = 10000;
        new CountDownTimer(startTime, 1000) {
            @Override
            public void onTick(long l) {
                NumberFormat f = new DecimalFormat("00");
                timerUp.setText(f.format(startTime/1000 - l/1000));
            }

            @Override
            public void onFinish() {
                timerUp.setText("Finish");

            }
        }.start();
    }
}
